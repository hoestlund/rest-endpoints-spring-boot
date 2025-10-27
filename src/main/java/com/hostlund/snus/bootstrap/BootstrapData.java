package com.hostlund.snus.bootstrap;

import com.hostlund.snus.model.Address;
import com.hostlund.snus.model.Customer;
import com.hostlund.snus.model.Flavour;
import com.hostlund.snus.model.Manufacturer;
import com.hostlund.snus.model.Snus;
import com.hostlund.snus.repositories.CustomerRepository;
import com.hostlund.snus.repositories.SnusRepository;
import com.neovisionaries.i18n.CountryCode;
import java.time.LocalDateTime;
import java.util.Arrays;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BootstrapData implements CommandLineRunner {

    private final SnusRepository snusRepository;
    private final CustomerRepository customerRepository;

    @Override
    public void run(String... args) throws Exception {
        loadSnusData();
        loadCustomerData();
    }

    private void loadSnusData() {
        if (snusRepository.findAll().isEmpty()) {
            Snus pine = Snus.builder().name("Pine")
                .description("Wood series. Pine needles, nordic cedar, delicate spices and mint")
                .createdDate(LocalDateTime.now())
                .updatedDate(LocalDateTime.now())
                .flavour(new Flavour("Pine flavour"))
                .manufacturer(
                    Manufacturer.builder()
                        .name("NOTO")
                        .address(Address.builder()
                            .firstLine("Bug Street 123")
                            .city("Berlin")
                            .country(CountryCode.DE)
                            .build())
                        .build())
                .build();

            Snus veryBerry = Snus.builder().name("Apres N°7 Very Berry")
                .description("Long release wild berry and raspberry")
                .createdDate(LocalDateTime.now())
                .updatedDate(LocalDateTime.now()).build();

            Snus appletini = Snus.builder().name("Apres N°6 Appletini")
                .description("Refreshing green apple")
                .createdDate(LocalDateTime.now())
                .updatedDate(LocalDateTime.now())
                .build();

            snusRepository.saveAll(Arrays.asList(pine, veryBerry, appletini));
        }
    }

    private void loadCustomerData() {
        if (customerRepository.findAll().isEmpty()) {
            Customer customer_1 = Customer.builder()
                .firstName("Laila")
                .lastName("Ross")
                .email("laila.ross@gmail.com")
                .address(Address.builder()
                    .firstLine("Puttbusser Str")
                    .houseNumber(8)
                    .city("Berlin")
                    .country(CountryCode.DE)
                    .build())
                .build();

            Customer customer_2 = Customer.builder()
                .firstName("Jeremy")
                .lastName("Walton")
                .email("jwally@gmail.com")
                .address(Address.builder()
                    .firstLine("Högsbogatan")
                    .houseNumber(23)
                    .city("Gothenburg")
                    .country(CountryCode.SE)
                    .build())
                .build();

            customerRepository.save(customer_1);
            customerRepository.save(customer_2);
        }
    }


}
