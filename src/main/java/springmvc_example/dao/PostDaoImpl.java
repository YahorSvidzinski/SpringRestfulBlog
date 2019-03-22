package springmvc_example.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import springmvc_example.model.Post;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
@Transactional
public class PostDaoImpl implements PostDao {

    @Autowired
    private SessionFactory sessionFactory;

    protected Session getSession(){
        return sessionFactory.getCurrentSession();
    }

    @Override
    public List findAll() {
        Criteria criteria = getSession().createCriteria(Post.class);
        return criteria.list();

    }

    @Override
    public void saveorupdate(Post post) {
       getSession().saveOrUpdate(post);
    }

    @Override
    public Post findById(int id) {
       return (Post)getSession().get(Post.class,id);

       /* return this.posts.stream()
                .filter(p -> Objects.equals(p.getId(), id))
                .findFirst()
                .orElse(null);*/
    }

    @Override
    public void deleteById(int id) {
       Post post = (Post)getSession().get(Post.class,id);
      getSession().delete(post);
    }
}
