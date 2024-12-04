import calc.CalculatorService;
import orders.OrderService;
import org.junit.jupiter.api.*;
import org.mockito.Mockito;
import orders.Order;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class MockingExamplesTest {


    //создание моков
    @Test
    public void summarizeTest(){
        CalculatorService calcMock = Mockito.mock(CalculatorService.class);
        Mockito.when(calcMock.sum(10,2)).thenReturn(12);
//        calc.CalculatorService cs = new calc.CalculatorService(calcMock);
//        int result = cs.sum(10,2);
        assertEquals(12,calcMock.sum(10,2));
    }

    //стаббинг с проверкой вызова метода / проверка, был ли вызван метод с передаваемыми параметрами
    @Test
    public void summarizeWhenThenReturnTest(){
        CalculatorService calcMock = Mockito.mock(CalculatorService.class);
        //не делаем ничего, если вызовут
        Mockito.doNothing().when(calcMock).printer(2);
        //вызываем метод явно
        calcMock.sum(10,2);
        //проверяем, что метод действительно был вызван с параметрами (х,у)
        Mockito.verify(calcMock).sum(10,2);
    }


    //проверка методов использующих объекты
    @Test
    public void checkTheOrder(){
        //мок
        OrderService orders = Mockito.mock(OrderService.class);
        //заказ
        Order order = new Order("name1", 2);
        //вызов метода
        orders.placeOrder(order);
        //был ли вызван метод placeOrder() с конкретным параметром order
        Mockito.verify(orders).placeOrder(order);
    }
}
