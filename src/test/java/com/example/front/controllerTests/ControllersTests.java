package com.example.front.controllerTests;

import com.example.front.Model.ShoppingCart;
import com.example.front.repository.AppRepository;
import com.example.front.repository.ProductEntity;
import com.example.front.service.IndexService;
import com.example.front.service.ShoppingService;
import org.apache.catalina.session.StandardSessionFacade;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import javax.servlet.http.HttpSession;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.mockito.BDDMockito.willDoNothing;
import static org.mockito.Mockito.*;

//@WebMvcTest
@RunWith(MockitoJUnitRunner.class)
public class ControllersTests {

    @Mock
    AppRepository repository;
    @InjectMocks
    ShoppingService service;
    @InjectMocks
    IndexService serviceIndex;


    @Test
    public void testSetMVC() {
        // Przygotowanie danych testowych
         // Przekazanie do konstruktora

        HttpSession session = new StandardSessionFacade(null);//mock(HttpSession.class);
        Model model = new ExtendedModelMap();//mock(Model.class);
        List<ProductEntity> products = repository.findAll()
                .stream()
                .filter(p -> !p.getPicture().isEmpty())
                .collect(Collectors.toList());
        List<ShoppingCart> cart = new ArrayList<>();
        cart.add(new ShoppingCart(1,5));
        cart.add(new ShoppingCart(10,5));
        cart.add(new ShoppingCart(20,5));
        cart.add(new ShoppingCart(30,5));
        cart.add(new ShoppingCart(40,5));
        int cartQuantity = 0;
        int sumPrice = 0;

        // Wywołanie testowanej metody
        serviceIndex.setIndexMVC(session, model, products, cart, cartQuantity, sumPrice);

        // Weryfikacja, ile razy została wywołana metoda getProductById() na zmockowanym repozytorium
        verify(repository, times(cart.size())).getProductByProductId(anyLong());
    }

}
