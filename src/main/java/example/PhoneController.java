package example;

import org.hibernate.ResourceClosedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/phone")
public class PhoneController {

    @Autowired
    private PhoneService phoneService;

    @GetMapping("/index")
    public Resource getCall(){return new ClassPathResource("templates/phone.html");
    }
    @PostMapping("")
    public boolean postPhone(@RequestBody PhoneDto phoneDto){
        boolean result = phoneService.postPhone(phoneDto);
        return result;
    }
    @GetMapping("")
    public List<PhoneDto> getPhone(){
        List<PhoneDto> result = phoneService.getPhone();
        return result;
    }
    @PutMapping("")
    public boolean putPhone(@RequestBody PhoneDto phoneDto){
        boolean result = phoneService.putPhone(phoneDto);
        return result;
    }
    @DeleteMapping("")
    public boolean deletePhone(@RequestParam int pno){
        boolean result = phoneService.deletePhone(pno);
        return result;
    }



}
