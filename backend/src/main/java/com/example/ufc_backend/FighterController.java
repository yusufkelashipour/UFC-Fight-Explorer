package com.example.ufc_backend;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin; // 👈 add this import
import com.opencsv.CSVReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000") // 👈 allow your React frontend
public class FighterController {
    
    @GetMapping("/test")
    public Map<String, String> test() {
        return Map.of(
            "message", "UFC Backend API is working!",
            "status", "success"
        );
    }
    
    @GetMapping("/fighters")
    public List<Fighter> getFighters() {
        List<Fighter> fighters = new ArrayList<>();
        
        try {
            InputStream inputStream = getClass().getResourceAsStream("/ufc-master.csv");
            CSVReader reader = new CSVReader(new InputStreamReader(inputStream));
            
            String[] headers = reader.readNext();
            String[] row;
            
            while ((row = reader.readNext()) != null) {
                String redFighter = row[0];
                String blueFighter = row[1];
                String blueWins = row[32];
                String redWins = row[55];
                String blueLoss = row[23];
                String redLoss = row[46];
                String blueHeight = row[34];
                String redHeight = row[57];
                String blueReach = row[35];
                String redReach = row[58];
                String blueAge = row[61];
                String redAge = row[60];
                String weightClass = row[11];

                fighters.add(new Fighter(redFighter, parseIntegerSafely(redWins), parseIntegerSafely(redLoss), parseIntegerSafely(redHeight), parseIntegerSafely(redReach), parseIntegerSafely(redAge), weightClass));
                fighters.add(new Fighter(blueFighter, parseIntegerSafely(blueWins), parseIntegerSafely(blueLoss), parseIntegerSafely(blueHeight), parseIntegerSafely(blueReach), parseIntegerSafely(blueAge), weightClass));
                
                //if (fighters.size() >= 20) break;
            }
            
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return fighters;
    }
    
    @GetMapping("/fighters/search")
    public List<Fighter> searchFighters(@RequestParam String name) {
        List<Fighter> allFighters = getFighters();
        List<Fighter> matchedFighters = new ArrayList<>();
        
        String searchTerm = name.toLowerCase().trim();
        
        for (Fighter fighter : allFighters) {
            if (fighter.getName().toLowerCase().contains(searchTerm)) {
                matchedFighters.add(fighter);
            }
        }
        
        return matchedFighters;
    }
    
    private Integer parseIntegerSafely(String value) {
        try {
            if (value == null || value.trim().isEmpty()) {
                return 0;
            }
            return (int) Double.parseDouble(value.trim());
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}
