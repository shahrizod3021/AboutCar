package oracleexample.oracledatabase.Service;

import lombok.RequiredArgsConstructor;
import oracleexample.oracledatabase.Entity.Attachment;
import oracleexample.oracledatabase.Entity.AttachmentContent;
import oracleexample.oracledatabase.Repository.AttachmentContentRepository;
import oracleexample.oracledatabase.Repository.AttachmentRepository;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.IOException;
import java.util.Iterator;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AttachmentService {

    private final AttachmentRepository attachmentRepository;

    private final AttachmentContentRepository attachmentContentRepository;


    public HttpEntity<?> upload(MultipartHttpServletRequest request) {
        try {
            Iterator<String> fileNames = request.getFileNames();
            MultipartFile file = request.getFile(fileNames.next());
            Attachment attachment = new Attachment(
                    file.getOriginalFilename(),
                    file.getContentType(),
                    file.getSize()
            );
            Attachment save = attachmentRepository.save(attachment);
            AttachmentContent attachmentContent = new AttachmentContent(
                    save,
                    file.getBytes()
            );
            attachmentContentRepository.save(attachmentContent);
            return ResponseEntity.ok(save.getId());
        } catch (IOException e) {
            return ResponseEntity.badRequest().body("uzur siz 10mb dan katta hajmdagi rasmni joylay olmaysiz");
        }
    }

    public HttpEntity<?> getFileJon(UUID id) {
        Optional<Attachment> byId = attachmentRepository.findById(id);
        if (byId.isPresent()) {
            AttachmentContent attachmentContent = attachmentContentRepository.findByAttachmentId(id);
            Attachment attachment = byId.get();
            return ResponseEntity.ok()
                    .contentType(MediaType.valueOf(attachment.getContentType()))
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + attachment.getName() + "\"")
                    .body(attachmentContent.getBytes());
        }
        return null;
    }
}
