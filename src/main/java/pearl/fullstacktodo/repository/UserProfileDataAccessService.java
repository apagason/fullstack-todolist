package pearl.fullstacktodo.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import pearl.fullstacktodo.datastore.FakeUserProfileDataStore;
import pearl.fullstacktodo.model.UserProfile;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class UserProfileDataAccessService {

    private final FakeUserProfileDataStore fakeUserProfileDataStore;

    public List<UserProfile> getUserProfiles() {
        return fakeUserProfileDataStore.getUserProfiles();
    }
}
