package net.amity.eternalsmp.item;
import net.amity.eternalsmp.EternalSMPItems;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import javax.swing.*;

public class ModItemGroups {
    public static final ItemGroup ETERNAL_ITEMS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(EternalSMPItems.MOD_ID,"eternal"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.ETERNAL_LOGO))
                    .displayName(Text.translatable("itemgroup.eternalsmp.eternal"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.ETERNAL_LOGO);
                        entries.add(ModItems.XERETHIS_STAFF);
                        entries.add(ModItems.TOME);
                        entries.add(ModItems.WIND_TOME);
                        entries.add(ModItems.FIRE_TOME);
                        entries.add(ModItems.DEATH_TOME);
                        entries.add(ModItems.STARDUST);
                        entries.add(ModItems.STARDUST_STICK);
                        entries.add(ModItems.STARDUST_SWORD);
                        entries.add(ModItems.STARDUST_PICKAXE);
                        entries.add(ModItems.STARDUST_SHOVEL);
                        entries.add(ModItems.STARDUST_AXE);
                        entries.add(ModItems.STARDUST_HOE);
                        entries.add(ModItems.STARDUST_HELMET);
                        entries.add(ModItems.STARDUST_CHESTPLATE);
                        entries.add(ModItems.STARDUST_LEGGINGS);
                        entries.add(ModItems.STARDUST_BOOTS);
                    })


                      .build());

    public static void registerItemGroups() {
        EternalSMPItems.LOGGER.info("Registering Item Groups for " + EternalSMPItems.MOD_ID);

    }
}
