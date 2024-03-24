package hasanalmunawrDev.UserDetailManager.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping(path = "/api")
public class UserControllerByHasa {

    @GetMapping(path = "/anyone")
    public ResponseEntity<?> getTestApi() {
        return ResponseEntity.ok("Anyone can acces it");
    }

    @PreAuthorize("hasAnyRole('ROLE_MANAGER','ROLE_ADMIN')") // admin can acces manager, but manager can not
    @GetMapping(path = "/manager")
    public ResponseEntity<?> callManager(Principal principal) {
        return ResponseEntity.ok("Acces Manager By "+ principal.getName());
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping(path = "/admin")
    public ResponseEntity<?> callAdmin(Principal principal) {
        return ResponseEntity.ok("Acces Admin By "+ principal.getName());
    }




}
