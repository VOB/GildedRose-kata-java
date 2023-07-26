package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void updateCommonItem() {
        GildedRose app = new GildedRose(new Item[] {new Item("sword", 10, 10)});
        app.updateQuality();
        assertEquals("sword", app.items[0].name);
        assertEquals(9, app.items[0].sellIn);
        assertEquals(9, app.items[0].quality);
    }

    @Test
    void updateItemWhenSellInIsNegative() {
        GildedRose app = new GildedRose(new Item[] {new Item("sword", -1, 10)});
        app.updateQuality();
        assertEquals(-2, app.items[0].sellIn);
        assertEquals(8, app.items[0].quality);
    }

    @Test
    void verifyQualityOfItemsIsNeverNegative() {
        Item[] items = new Item[] {
            new Item("Common greaves", 1, 0),
            new Item("Common greaves", 1, 1)
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        for (Item item : app.items) {
            assertEquals(0, item.quality);
        }
    }

    @Test
    void updateAgedBrie() {
        GildedRose app = new GildedRose(new Item[] {new Item("Aged Brie", 10, 10)});
        app.updateQuality();
        assertEquals(9, app.items[0].sellIn);
        assertEquals(11, app.items[0].quality);
    }

    @Test
    void updateBackstagePass() {
        GildedRose app = new GildedRose(new Item[] {new Item("Backstage passes to a TAFKAL80ETC concert", 20, 10)});
        app.updateQuality();
        assertEquals(19, app.items[0].sellIn);
        assertEquals(11, app.items[0].quality);
    }

    @Test
    void updateBackstagePass10DaysOrLess() {
        GildedRose app = new GildedRose(new Item[] {new Item("Backstage passes to a TAFKAL80ETC concert", 10, 10)});
        app.updateQuality();
        assertEquals(9, app.items[0].sellIn);
        assertEquals(12, app.items[0].quality);
    }

    @Test
    void updateBackstagePass5DaysOrLess() {
        GildedRose app = new GildedRose(new Item[] {new Item("Backstage passes to a TAFKAL80ETC concert", 5, 10)});
        app.updateQuality();
        assertEquals(4, app.items[0].sellIn);
        assertEquals(13, app.items[0].quality);
    }

    @Test
    void updateBackstagePass0DaysLeft() {
        GildedRose app = new GildedRose(new Item[] {new Item("Backstage passes to a TAFKAL80ETC concert", 0, 30)});
        app.updateQuality();
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }

    @Test
    void updateLegendaryItem() {
        GildedRose app = new GildedRose(new Item[] {new Item("Sulfuras, Hand of Ragnaros", 0, 80)});
        app.updateQuality();
        assertEquals(0, app.items[0].sellIn);
        assertEquals(80, app.items[0].quality);
    }

    @Test
    void updateQualityDoesntIncreaseQualityAbove50() {
        Item[] items = new Item[] {
            new Item("Aged Brie", 1, 50),
            new Item( "Backstage passes to a TAFKAL80ETC concert", 1, 50),
            new Item( "Backstage passes to a TAFKAL80ETC concert", 1, 49)
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, app.items[0].quality);
        assertEquals(50, app.items[1].quality);
        assertEquals(50, app.items[2].quality);
    }

}
