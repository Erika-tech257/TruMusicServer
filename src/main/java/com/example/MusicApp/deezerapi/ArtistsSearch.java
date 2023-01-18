package com.example.MusicApp.deezerapi;

import com.example.MusicApp.models.Artist;
import com.example.MusicApp.services.APIClientService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class ArtistsSearch {

    /**
     * may want to use a for loop instead
     * @param id
     */

    public void search(String id) {
//        APIClientService.get("https://www.deezer.com/artist/" + id);
        int count;
        Artist artist = new Artist();
        List<Artist> artistList = new ArrayList<>();
        for (int i = 0; i <id.length(); i++) {
//            System.out.println(id[i]);
        }
    }

    public int longestSubstring(String s, int k) {
        int windowStart = 0;
        int maxLength = 0;
        Map<Character, Integer> freqMap = new HashMap<>();
        // in the following loop we'll try to extend the range [windowStart, windowEnd]
        for (int windowEnd = 0; windowEnd < s.length(); windowEnd++) {
            char rightChar = s.charAt(windowEnd);
            freqMap.put(rightChar, freqMap.getOrDefault(rightChar, 0) + 1);
            // shrink the sliding window, until we are left with 'k' distinct characters in the frequency map
            while (freqMap.size() > k) {
                char leftChar = s.charAt(windowStart);
                freqMap.put(leftChar, freqMap.get(leftChar) - 1);
                if (freqMap.get(leftChar) == 0) {
                    freqMap.remove(leftChar);
                }
                windowStart++; //shrink the window
            }
            // remember the maximum length so far
            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }
        return maxLength;
    }

    public void artSearch() throws IOException {

        Artist artist = new Artist();
        artist.setId(1);
        artist.setName("Beatles");
        artist.setArtist_img("picture");

        //create object mapper class object
        ObjectMapper mapper = new ObjectMapper();
        //to print string in json format
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        //convert object into string
        String artJson = mapper.writeValueAsString(artist);
        //print json string
        System.out.println(artJson);

        //convert json string into artist object
        Artist art = mapper.readValue(artJson.getBytes(), Artist.class);
        //print values from art object
        System.out.println(art.getId());
        System.out.println(art.getName());
        System.out.println(art.getArtist_img());


    }

}
