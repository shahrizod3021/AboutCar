package oracleexample.oracledatabase.Controller;

import lombok.RequiredArgsConstructor;
import oracleexample.oracledatabase.Service.AttachmentService;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.util.UUID;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/v1/api/attachment")
public class AttachmentController {

    private final AttachmentService attachmentService;

    @PostMapping("/upload")
    public HttpEntity<?> uploadFile(MultipartHttpServletRequest request) {
        return attachmentService.upload(request);
    }

    @GetMapping("/download")
    public HttpEntity<?> getFile(@RequestParam(name = "id", required = false) UUID id) {
        return attachmentService.getFileJon(id);
    }
}
