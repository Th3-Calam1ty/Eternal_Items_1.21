package net.amity.eternalsmp.item;

import net.amity.eternalsmp.EternalSMPItems;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item XERETHIS_STAFF = registerItem("xerethis_staff", new Item(new Item.Settings()));
    public static final Item ETERNAL_LOGO = registerItem("eternal_logo", new Item(new Item.Settings()));
    public static final Item WIND_TOME = registerItem("wind_tome", new Item(new Item.Settings()));


    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(EternalSMPItems.MOD_ID, name ), item);
    }

    public static void registerModItems() {
        EternalSMPItems.LOGGER.info("Registering Mod Items for " + EternalSMPItems.MOD_ID);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(entires -> {
            entires.add(XERETHIS_STAFF);
        });
    }
}