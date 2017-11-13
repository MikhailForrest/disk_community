package ru.diskcommunity.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.diskcommunity.domain.DisksEntity;
import ru.diskcommunity.service.DisksService;

import java.util.List;

@Controller
@RequestMapping(value = "/disks")
public class MyController {

    @Autowired
    DisksService disksService;

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    List<DisksEntity> getOwnDisksForUser(@RequestParam(value = "user_id", required = false) Integer userId,
                                         @RequestParam(value = "is_free", required = false) Boolean isFree) {
        if (userId != null) {
            if (isFree != null) {
                if (isFree = true) {
                    List<DisksEntity> listOfDisks = disksService.DisksTakenFromUser(userId);
                    return listOfDisks;
                } else {
                    List<DisksEntity> listOfDisks = disksService.DisksTakenByUser(userId);
                    return listOfDisks;
                }
            } else {
                List<DisksEntity> listOfDisks = disksService.OwnDisksForUser(userId);
                return listOfDisks;
            }
        } else {
            if (isFree != null) {
                return null;
            } else {
                List<DisksEntity> listOfDisks = disksService.AllFreeDisks();
                return listOfDisks;
            }
        }

    }
}
