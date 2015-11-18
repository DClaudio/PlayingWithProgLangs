import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SimpleOrderManagerTest {

    private SimpleOrderManager simpleOrderManager;
    private OrderStore mockOrderStore;
    private OrderWriter mockOrderWriter;

    @Before
    public void setup(){
        mockOrderStore = EasyMock.createMock(OrderStore.class);
        mockOrderWriter = EasyMock.createMock(OrderWriter.class);
        simpleOrderManager = new SimpleOrderManager(mockOrderStore,mockOrderWriter);
    }

    @Test(expected = InvalidOperationException.class)
    public void shouldThrowExceptionWhenOrderListEmpty(){
        //set mock behaviour
        EasyMock.expect(mockOrderStore.getOrders()).andReturn(Collections.<Order>emptyList());
        EasyMock.replay(mockOrderStore);
        //execute
        simpleOrderManager.writeAllOrders();
    }

    @Test
    public void shouldWriteOrdersWhenOrderListNotEmpty(){
        //prepare test data
        List<Order> orders = new ArrayList<Order>();
        orders.add(new Order());
        //set mock behaviour
        EasyMock.expect(mockOrderStore.getOrders()).andReturn(orders);
        mockOrderWriter.writeOrders(orders);
        EasyMock.expectLastCall().times(1);
        //activate the mocks
        EasyMock.replay(mockOrderStore);
        EasyMock.replay(mockOrderWriter);
        //execute
        simpleOrderManager.writeAllOrders();
        //verify mocks
        EasyMock.verify(mockOrderStore);
        EasyMock.verify(mockOrderWriter);
    }
}