package com.communityBatch.crawler.entity;

import lombok.Builder;
import lombok.Getter;
import java.time.LocalDateTime;

@Builder
@Getter
public class Match {
    private Long id;
    private String title;
    private LocalDateTime time;
    private String address;
    private int price;
    private String info;
    private String status;
    private String link;
    private int sex;

    @Override
    public String toString() {
        return  "id : " + id + "\n" +
                "title : " + title + "\n" +
                "time : " + time + "\n" +
                "address : " + address + "\n" +
                "price : " + price + "\n" +
                "info : " + info + "\n" +
                "status : " + status + "\n" +
                "link : " + link + "\n";
    }

    public static Match from(PlabMatch plabMatch){
        String LINK_URL = "https://www.plabfootball.com/match/";
        String info = "인원 : " + (plabMatch.getMax_player_cnt() - plabMatch.getConfirm_cnt()) + "\n" +
                       "경기 : " + plabMatch.getPlayer_cnt() + "vs" + plabMatch.getPlayer_cnt() + "\n" +
                        plabMatch.getType() + "파전" + "\n" +
                        plabMatch.getGrade();
        return Match.builder()
                .id(plabMatch.getId())
                .title(plabMatch.getLabel_title())
                .time(plabMatch.getSchedule().toLocalDateTime())
                .address(plabMatch.getLabel_stadium())
                .price(plabMatch.getFee())
                .sex(plabMatch.getSex())
                .info(info)
                .status(plabMatch.getStatus())
                .link(LINK_URL+plabMatch.getId())
                .build();
    }
}
