package com.patika.messaging.service;


import com.patika.messaging.domain.SaleAdvertisementDTO;
import com.patika.messaging.domain.UserDTO;
import com.patika.messaging.repository.AdvertRepository;
import com.patika.messaging.repository.UserRepository;
import com.patika.messaging.utils.AdvertDetailsGenerator;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AdvertServiceImpl implements AdvertService {

    private final UserRepository userRepository;
    private final AdvertRepository advertRepository;

    public AdvertServiceImpl(UserRepository userRepository, AdvertRepository advertRepository) {
        this.userRepository = userRepository;
        this.advertRepository = advertRepository;
    }

    @Override
    @Transactional
    public void createRandomAdvert() throws InterruptedException {
        int numberOfAdvert = 10;

        while(numberOfAdvert > 0){
            UserDTO user = userRepository.getRandomUser();

            SaleAdvertisementDTO newAdvert = new SaleAdvertisementDTO();
            newAdvert.setUser(user);
            newAdvert.setTitle(AdvertDetailsGenerator.generateTitle());
            newAdvert.setDetails(AdvertDetailsGenerator.generateDetail());


            System.out.println(user.toString());

            advertRepository.save(newAdvert);
            userRepository.save(user);


            numberOfAdvert--;
        }
    }

}
