package n_1.mock;

import n_1.domain.Store;
import n_1.domain.Employee;
import n_1.domain.Product;
import n_1.domain.StoreRepository;
import n_1.domain.list_change_set_domain.EmployeeSet;
import n_1.domain.list_change_set_domain.ProductSet;
import n_1.domain.list_change_set_domain.StoreSet;
import n_1.domain.list_change_set_domain.StoreSetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class MockStoreData {

    @Autowired
    private StoreRepository storeRepository;

    @Autowired
    private StoreSetRepository storeSetRepository;

    public void saveStores() {
        Store store1 = new Store("서점", "서울시 강남구");
        store1.addProduct(new Product("책1_1", 10000L));
        store1.addProduct(new Product("책1_2", 20000L));
        store1.addEmployee(new Employee("직원1", LocalDate.now()));
        storeRepository.save(store1);

        Store store2 = new Store("서점2", "서울시 강남구");
        store2.addProduct(new Product("책2_1", 10000L));
        store2.addProduct(new Product("책2_2", 20000L));
        store2.addEmployee(new Employee("직원2", LocalDate.now()));
        storeRepository.save(store2);

        Store store3 = new Store("서점3", "서울시 강남구");
        store3.addProduct(new Product("책3_1", 10000L));
        store3.addProduct(new Product("책3_2", 20000L));
        store3.addEmployee(new Employee("직원3", LocalDate.now()));
        storeRepository.save(store3);
    }

    public void saveStoresSet() {
        StoreSet store1 = new StoreSet("서점", "서울시 강남구");
        store1.addProduct(new ProductSet("책1_1", 10000L));
        store1.addProduct(new ProductSet("책1_2", 20000L));
        store1.addEmployee(new EmployeeSet("직원1", LocalDate.now()));
        storeSetRepository.save(store1);

        StoreSet store2 = new StoreSet("서점2", "서울시 강남구");
        store2.addProduct(new ProductSet("책2_1", 10000L));
        store2.addProduct(new ProductSet("책2_2", 20000L));
        store2.addEmployee(new EmployeeSet("직원2", LocalDate.now()));
        storeSetRepository.save(store2);

        StoreSet store3 = new StoreSet("서점3", "서울시 강남구");
        store3.addProduct(new ProductSet("책3_1", 10000L));
        store3.addProduct(new ProductSet("책3_2", 20000L));
        store3.addEmployee(new EmployeeSet("직원3", LocalDate.now()));
        storeSetRepository.save(store3);
    }
}
