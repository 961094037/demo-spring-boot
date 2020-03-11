package com.example.demo;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
public class Pokers {

    private List<Poker> pokers;

    private SuitPatterns suitPatterns;

    private int first;
    private int second = 0;
    private int thrid = 0;
    private int four = 0;
    private int five = 0;

    public Pokers(List<Poker> pokers){
        this.pokers = pokers.stream().sorted(Comparator.comparing(Poker::getValue)).collect(Collectors.toList());
        checkPatterns();
    }

    private void checkPatterns(){
        isTonghuashun();
    }

    /** 同花顺检测 */
    private void isTonghuashun(){
        //是否是同花顺
        if (tonghuaCheck() && shunziCheck()){
            suitPatterns = SuitPatterns.tonghuashun;
            setShunziTou();
        }else {
            issitiao();
        }
    }

    /** 四条检测 */
    private void issitiao(){
        if (pokers.get(1).getValue() == pokers.get(2).getValue() && pokers.get(2).getValue() == pokers.get(3).getValue()){
            if (pokers.get(0).getValue() == pokers.get(1).getValue()){
                suitPatterns = SuitPatterns.sitiiao;
                first = pokers.get(3).getValue();
                second = pokers.get(4).getValue();
            }else if(pokers.get(4).getValue() == pokers.get(3).getValue()){
                suitPatterns = SuitPatterns.sitiiao;
                first = pokers.get(3).getValue();
                second = pokers.get(0).getValue();
            }else {
                issantiao();
            }
        }else {
            ishulu();
        }
    }

    /** 葫芦检测 */
    private void ishulu(){

        if (pokers.get(0).getValue() == pokers.get(1).getValue() && pokers.get(1).getValue() == pokers.get(2).getValue()){
            if (pokers.get(3).getValue() == pokers.get(4).getValue()){
                suitPatterns = SuitPatterns.hulu;
                first = pokers.get(0).getValue();
                second = pokers.get(4).getValue();
            }else {
                issantiao();
            }
        }else if (pokers.get(2).getValue() == pokers.get(3).getValue() && pokers.get(3).getValue() == pokers.get(4).getValue()) {
            if (pokers.get(0).getValue() == pokers.get(1).getValue()){
                suitPatterns = SuitPatterns.hulu;
                first = pokers.get(4).getValue();
                second = pokers.get(0).getValue();
            }else {
                issantiao();
            }
        }else {
            istonghua();
        }
    }

    /** 同花检测 */
    private void istonghua(){
        if (tonghuaCheck()){
            suitPatterns = SuitPatterns.tonghua;
            sanpaiValue();
        }else {
            isshunzi();
        }
    }

    /** 同花检测方法 */
    private boolean tonghuaCheck(){
        if (pokers.get(0).getFlowerColor() == pokers.get(1).getFlowerColor() && pokers.get(1).getFlowerColor() == pokers.get(2).getFlowerColor()
                && pokers.get(2).getFlowerColor() == pokers.get(3).getFlowerColor() && pokers.get(3).getFlowerColor() == pokers.get(4).getFlowerColor()){
            return true;
        }
        return false;
    }

    /** 顺子检测 */
    private void  isshunzi(){
        if (shunziCheck()){
            suitPatterns = SuitPatterns.shunzi;
            setShunziTou();
        }else {
            issantiao();
        }
    }

    /** 顺子检测方法 */
    private boolean shunziCheck(){
        //是否是顺子
        if (pokers.get(0).getValue() + 1 == pokers.get(1).getValue() && pokers.get(1).getValue() + 1 == pokers.get(2).getValue() && pokers.get(2).getValue() + 1 == pokers.get(3).getValue()
                && (pokers.get(3).getValue() + 1 == pokers.get(4).getValue() || (pokers.get(0).getValue() == 2 && pokers.get(4).getValue() == 14))){
            return true;
        }
        return false;
    }

    /** 设置顺子的头 */
    private void setShunziTou(){
        if (pokers.get(3).getValue() == 5 && pokers.get(4).getValue() == 14){
            first = 5;
        }else {
            first = pokers.get(4).getValue();
        }
    }

    /** 三条检测 */
    private void issantiao(){
        if (pokers.get(0).getValue() == pokers.get(1).getValue() && pokers.get(1).getValue() == pokers.get(2).getValue()){
            suitPatterns = SuitPatterns.santiao;
            first = pokers.get(2).getValue();
            second = pokers.get(4).getValue();
            thrid = pokers.get(3).getValue();
        }else if (pokers.get(1).getValue() == pokers.get(2).getValue() && pokers.get(2).getValue() == pokers.get(3).getValue()){
            suitPatterns = SuitPatterns.santiao;
            first = pokers.get(2).getValue();
            second = pokers.get(4).getValue();
            thrid = pokers.get(0).getValue();
        }else if (pokers.get(2).getValue() == pokers.get(3).getValue() && pokers.get(3).getValue() == pokers.get(4).getValue()){
            suitPatterns = SuitPatterns.santiao;
            first = pokers.get(2).getValue();
            second = pokers.get(1).getValue();
            thrid = pokers.get(0).getValue();
        }else {
            isliangdui();
        }
    }

    /** 两对检测 */
    private void isliangdui(){
        if (pokers.get(0).getValue() == pokers.get(1).getValue() && pokers.get(2).getValue() == pokers.get(3).getValue()){
            suitPatterns = SuitPatterns.liangdui;
            first = pokers.get(3).getValue();
            second = pokers.get(0).getValue();
            thrid = pokers.get(4).getValue();
        }else if (pokers.get(0).getValue() == pokers.get(1).getValue() && pokers.get(3).getValue() == pokers.get(4).getValue()){
            suitPatterns = SuitPatterns.liangdui;
            first = pokers.get(3).getValue();
            second = pokers.get(0).getValue();
            thrid = pokers.get(2).getValue();
        }else if (pokers.get(1).getValue() == pokers.get(2).getValue() && pokers.get(3).getValue() == pokers.get(4).getValue()){
            suitPatterns = SuitPatterns.liangdui;
            first = pokers.get(3).getValue();
            second = pokers.get(1).getValue();
            thrid = pokers.get(0).getValue();
        }else{
            isdandui();
        }
    }

    /** 一对检测 */
    private void isdandui(){
        if (pokers.get(0).getValue() == pokers.get(1).getValue()){
            suitPatterns = SuitPatterns.dandui;
            first = pokers.get(0).getValue();
            second = pokers.get(4).getValue();
            thrid = pokers.get(3).getValue();
            four = pokers.get(2).getValue();
        }else if (pokers.get(1).getValue() == pokers.get(2).getValue()){
            suitPatterns = SuitPatterns.dandui;
            first = pokers.get(1).getValue();
            second = pokers.get(4).getValue();
            thrid = pokers.get(3).getValue();
            four = pokers.get(0).getValue();
        }else if (pokers.get(2).getValue() == pokers.get(3).getValue()){
            suitPatterns = SuitPatterns.dandui;
            first = pokers.get(2).getValue();
            second = pokers.get(4).getValue();
            thrid = pokers.get(1).getValue();
            four = pokers.get(0).getValue();
        }else if (pokers.get(3).getValue() == pokers.get(4).getValue()){
            suitPatterns = SuitPatterns.dandui;
            first = pokers.get(3).getValue();
            second = pokers.get(2).getValue();
            thrid = pokers.get(1).getValue();
            four = pokers.get(0).getValue();
        }else {
            sanpai();
        }
    }

    /** 散牌 */
    private void sanpai(){
        suitPatterns = SuitPatterns.sanpai;
        sanpaiValue();
    }

    /** 散牌的值 */
    private void sanpaiValue(){
        first = pokers.get(4).getValue();
        second = pokers.get(3).getValue();
        thrid = pokers.get(2).getValue();
        four = pokers.get(1).getValue();
        five = pokers.get(0).getValue();
    }

    /** 对比 */
    public int compare(Pokers b){
        if (suitPatterns.getValue() > b.suitPatterns.getValue()){
            return 1;
        }else if (suitPatterns.getValue() < b.suitPatterns.getValue()){
            return -1;
        }else {
            if (first > b.first){
                return 1;
            }else if (first < b.first) {
                return -1;
            }else{
                if (second > b.second){
                    return 1;
                }else if (second < b.second) {
                    return -1;
                }else{
                    if (thrid > b.thrid){
                        return 1;
                    }else if (thrid < b.thrid) {
                        return -1;
                    }else {
                        if (four > b.four){
                            return 1;
                        }else if (four < b.four) {
                            return -1;
                        }else {
                            if (five > b.five){
                                return 1;
                            }else if (five < b.five) {
                                return -1;
                            }else {
                                return 0;
                            }
                        }
                    }
                }
            }
        }
    }

}
