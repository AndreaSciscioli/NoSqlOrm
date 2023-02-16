package co.NoSqlOrm.mongoDbDemo.repositories;

import co.NoSqlOrm.mongoDbDemo.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User,String> {
}
