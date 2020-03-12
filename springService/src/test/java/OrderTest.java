import com.lovo.ss.entity.OrderEntity;
import com.lovo.ss.service.IOrderService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class OrderTest {

    @Test
    public void test(){
        ClassPathXmlApplicationContext context= new ClassPathXmlApplicationContext("application.xml");
        IOrderService service = (IOrderService) context.getBean("orderService");
        service.addOrder(new OrderEntity(5.5,2));
    }
}
