package pearl.fullstacktodo.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pearl.fullstacktodo.model.UserProfile;
import pearl.fullstacktodo.repository.UserProfileDataAccessService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserProfileService {

    private final UserProfileDataAccessService userProfileDataAccessService;

    public List<UserProfile> getUserProfiles() {
        return userProfileDataAccessService.getUserProfiles();
    }
}
