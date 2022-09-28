package pearl.fullstacktodo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pearl.fullstacktodo.model.UserProfile;
import pearl.fullstacktodo.service.UserProfileService;

import java.util.List;

@RestController
@RequestMapping("/image")
@RequiredArgsConstructor
public class UserProfileController {

    private final UserProfileService userProfileService;

    @GetMapping("/getUserProfile")
    public List<UserProfile> getUserProfiles() {
        return userProfileService.getUserProfiles();
    }
}
