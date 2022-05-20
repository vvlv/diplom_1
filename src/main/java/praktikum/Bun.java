package praktikum;

import java.util.Objects;

/**
 * Модель булочки для бургера.
 * Булочке можно дать название и назначить цену.
 */
public class Bun {

    public String name;
    public float price;

    public Bun(String name, float price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bun bun = (Bun) o;
        return Float.compare(bun.price, price) == 0 && Objects.equals(name, bun.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }
}