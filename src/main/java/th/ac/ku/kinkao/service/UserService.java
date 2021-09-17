package th.ac.ku.kinkao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import th.ac.ku.kinkao.model.User;
import th.ac.ku.kinkao.model.Vegetable;

import java.util.Arrays;
import java.util.List;

@Service
public class UserService
{
    @Autowired
    private RestTemplate restTemplate;

    public List<User> getAll()
    {
        String url = "http://localhost:8090/user";
        ResponseEntity<User[]> response = restTemplate.getForEntity(url, User[].class);
        User[] users = response.getBody();
        return Arrays.asList(users);
    }

    public void addUser(User user) {
        String url = "http://localhost:8090/user";

        restTemplate.postForObject(url, user, User.class);
    }

}
