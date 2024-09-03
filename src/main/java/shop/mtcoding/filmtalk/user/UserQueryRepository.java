package shop.mtcoding.filmtalk.user;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import shop.mtcoding.filmtalk.core.error.ex.Exception401;


@RequiredArgsConstructor
@Repository
public class UserQueryRepository {

    private final EntityManager em;

    //레파지토리에 기능명 x
    //persistence conext
    //new user 비영속객체
    //영속성컨텍스트에 들어오면 영속객체

    public User findByUsername(String username) {
        Query query = em.createQuery("select u from User u where u.username=:username", User.class);
        query.setParameter("username", username);

        try {
            User user = (User) query.getSingleResult();
            return user;
        } catch (Exception e) {
            return null;
        }

    }

    public User findByUsernameAndPassword(String username, String password) {
        Query query = em.createQuery("select u from User u where u.username=:username and u.password =:password", User.class);
        query.setParameter("username", username);
        query.setParameter("password", password);
        try {
            User user = (User) query.getSingleResult();
            return user;
        } catch (Exception e) {
            throw new Exception401("인증되지 않았습니다.");
        }


    }

    @Transactional
    public void save(User user) {
        System.out.println("담기기전 : " + user.getId());
        em.persist(user);
        System.out.println("담긴후 : " + user.getId());

    }
}
