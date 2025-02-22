package net.amity.eternalsmp.util;

import net.amity.eternalsmp.EternalSMPItems;
import net.minecraft.block.Block;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> NEEDS_STARDUST_TOOL = createTag("needs_stardust_tool");
        public static final TagKey<Block> INCORRECT_FOR_STARDUST_TOOL = createTag("incorrect_for_stardust_tool");


        private static TagKey<Block> createTag(String name){
            return TagKey.of(RegistryKeys.BLOCK, Identifier.of(EternalSMPItems.MOD_ID, name));
        }
    }
}
