package n_1.domain;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import n_1.domain.list_change_set_domain.EmployeeSet;
import n_1.domain.list_change_set_domain.ProductSet;
import n_1.domain.list_change_set_domain.StoreSet;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@NoArgsConstructor
@Getter
@Entity
public class StoreHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String storeName;
    private String productNames;
    private String employeeNames;

    public StoreHistory(Store store, List<Product> products, List<Employee> employees) {
        this.storeName = store.getName();
        this.productNames = products.stream()
                .map(Product::getName)
                .collect(Collectors.joining( "," ));

        this.employeeNames = employees.stream()
                .map(Employee::getName)
                .collect(Collectors.joining( "," ));
    }

    public StoreHistory(StoreSet store, Set<ProductSet> products, Set<EmployeeSet> employees) {
        this.storeName = store.getName();
        this.productNames = products.stream()
                .map(ProductSet::getName)
                .collect(Collectors.joining( "," ));
        this.employeeNames = employees.stream()
                .map(EmployeeSet::getName)
                .collect(Collectors.joining( "," ));
    }
}
