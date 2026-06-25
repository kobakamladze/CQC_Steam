package models;

import utils.CustomParser;

import java.util.Objects;

public class Game implements Comparable<Game> {

    private final String name;
    private final String discount;
    private final String price;
    private final String discountedPrice;

    public Game(String name, String discount, String price, String discountedPrice) {
        this.name = name;
        this.discount = discount;
        this.price = price;
        this.discountedPrice = discountedPrice;
    }

    public String getName() {
        return this.name;
    }

    public String getPrice() {
        return this.price;
    }

    public String getDiscount() {
        return discount;
    }

    public String getDiscountedPrice() {
        return this.discountedPrice;
    }

    @Override
    public String toString() {
        return String.format("Game - { name='%s', discount='%s', price='%s', discountedPrice=%s }",
                name, discount, price, discountedPrice);
    }

    @Override
    public int compareTo(Game o) {
        return Integer.compare(
                CustomParser.parsePercentFromStringToInteger(o.discount),
                CustomParser.parsePercentFromStringToInteger(this.discount)
        );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return Objects.equals(name, game.name)
                && Objects.equals(discount, game.discount)
                && Objects.equals(price, game.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, discount, price);
    }
}