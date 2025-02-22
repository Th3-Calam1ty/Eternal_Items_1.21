package net.amity.eternalsmp.item;

import net.amity.eternalsmp.EternalSMPItems;
import net.amity.eternalsmp.item.custom.DeathTome;
import net.amity.eternalsmp.item.custom.XerethisStaff;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.item.WindTome;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.amity.eternalsmp.item.custom.FireTome;

public class ModItems {
    public static final Item XERETHIS_STAFF = registerItem("xerethis_staff", new XerethisStaff(new Item.Settings().maxCount(1)));
    public static final Item ETERNAL_LOGO = registerItem("eternal_logo", new Item(new Item.Settings().maxCount(1)));
    public static final Item WIND_TOME = registerItem("wind_tome", new WindTome(new Item.Settings().maxCount(1).fireproof())); // Register WindTome correctly
    public static final Item FIRE_TOME = registerItem("fire_tome", new FireTome(new Item.Settings().maxCount(1).fireproof()));
    public static final Item DEATH_TOME = registerItem("death_tome", new DeathTome(new Item.Settings().maxCount(1).fireproof()));
    public static final Item TOME = registerItem("tome", new Item(new Item.Settings().maxCount(1).fireproof()));
    public static final Item STARDUST = registerItem("stardust", new Item(new Item.Settings()));
    public static final Item STARDUST_STICK = registerItem("stardust_stick", new Item(new Item.Settings()));

    public static final Item STARDUST_SWORD = registerItem("stardust_sword", new SwordItem(ModToolMaterials.STARDUST, new Item.Settings()
            .attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.STARDUST, 3, -2.4f ))));
    public static final Item STARDUST_PICKAXE = registerItem("stardust_pickaxe", new PickaxeItem(ModToolMaterials.STARDUST, new Item.Settings()
            .attributeModifiers(PickaxeItem.createAttributeModifiers(ModToolMaterials.STARDUST, 1, -2.8f ))));
    public static final Item STARDUST_SHOVEL = registerItem("stardust_shovel", new ShovelItem(ModToolMaterials.STARDUST, new Item.Settings()
            .attributeModifiers(ShovelItem.createAttributeModifiers(ModToolMaterials.STARDUST, 1.5f, -3f ))));
    public static final Item STARDUST_AXE = registerItem("stardust_axe", new AxeItem(ModToolMaterials.STARDUST, new Item.Settings()
            .attributeModifiers(AxeItem.createAttributeModifiers(ModToolMaterials.STARDUST, 6, -3.2f ))));
    public static final Item STARDUST_HOE = registerItem("stardust_hoe", new HoeItem(ModToolMaterials.STARDUST, new Item.Settings()
            .attributeModifiers(HoeItem.createAttributeModifiers(ModToolMaterials.STARDUST, 0, -3f ))));


    public static final Item STARDUST_HELMET = registerItem("stardust_helmet",
            new ArmorItem(ModArmorMaterials.STARDUST_ARMOR_MATERIAL, ArmorItem.Type.HELMET, new Item.Settings()
                    .maxDamage(ArmorItem.Type.HELMET.getMaxDamage(50))));
    public static final Item STARDUST_CHESTPLATE = registerItem("stardust_chestplate",
            new ArmorItem(ModArmorMaterials.STARDUST_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE, new Item.Settings()
                    .maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(50))));
    public static final Item STARDUST_LEGGINGS = registerItem("stardust_leggings",
            new ArmorItem(ModArmorMaterials.STARDUST_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS, new Item.Settings()
                    .maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(50))));
    public static final Item STARDUST_BOOTS = registerItem("stardust_boots",
            new ArmorItem(ModArmorMaterials.STARDUST_ARMOR_MATERIAL, ArmorItem.Type.BOOTS, new Item.Settings()
                    .maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(50))));



    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(EternalSMPItems.MOD_ID, name), item);
    }

    public static void registerModItems() {
        EternalSMPItems.LOGGER.info("Registering Mod Items for " + EternalSMPItems.MOD_ID);
    }
}
