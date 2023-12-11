package io.batch.optimization.batch.processor;

import io.batch.optimization.domain.Store;
import io.batch.optimization.domain.StoreHistory;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 해당 프로젝트에서 공통적으로 사용되는 Processor
 */
@RequiredArgsConstructor
@Configuration
public class StoreHistoryProcessorConfig {

    @Bean
    public ItemProcessor<Store, StoreHistory> storeToStoreHistoryProcessor() {
        return store -> new StoreHistory(store, store.getProducts(), store.getEmployees());
    }
}
