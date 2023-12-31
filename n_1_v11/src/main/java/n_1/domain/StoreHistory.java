package n_1.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import n_1.domain.set.EmployeeSet;
import n_1.domain.set.ProductSet;
import n_1.domain.set.StoreSet;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
