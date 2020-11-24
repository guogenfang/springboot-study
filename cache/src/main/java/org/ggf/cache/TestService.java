package org.ggf.cache;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class TestService {
    private static final Logger LOGGER = LoggerFactory.getLogger(TestService.class);

    private Map<Integer, UserModel> userModels = new HashMap<>();

    {
        userModels.put(1, new UserModel(1, "f-1"));
        userModels.put(2, new UserModel(2, "f-2"));
        userModels.put(3, new UserModel(3, "f-3"));
        userModels.put(4, new UserModel(4, "f-4"));
        userModels.put(5, new UserModel(4, "f-4"));
    }

    @Cacheable(value = {"UserModel"}, key = "#root.method.returnType.simpleName + '-' + #id", unless = "#result == null")
    public UserModel findById(Integer id) {
        LOGGER.info("find by id {}", id);
        return userModels.get(id);
    }

}
