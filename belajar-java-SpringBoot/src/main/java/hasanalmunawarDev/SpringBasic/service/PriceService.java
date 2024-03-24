package hasanalmunawarDev.SpringBasic.service;

import hasanalmunawarDev.SpringBasic.repository.PriceRepository;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PriceService {

    @Getter
    private PriceRepository repository;

    @Autowired
    public PriceService(PriceRepository repository) {
        this.repository = repository;
    }
}
