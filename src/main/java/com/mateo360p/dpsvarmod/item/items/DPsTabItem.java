
package com.mateo360p.dpsvarmod.item.items;

import net.minecraft.ChatFormatting;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.network.chat.Component;
import java.util.List;
import com.google.common.collect.Multimap;
import com.google.common.collect.ImmutableMultimap;

public class DPsTabItem extends Item {
    public DPsTabItem() {
        super(new Item.Properties().stacksTo(1).fireResistant().rarity(Rarity.EPIC));
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getDefaultAttributeModifiers(EquipmentSlot equipmentSlot) {
        if (equipmentSlot == EquipmentSlot.MAINHAND) {
            ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
            builder.putAll(super.getDefaultAttributeModifiers(equipmentSlot));
            builder.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_UUID, "Item modifier", 998d, AttributeModifier.Operation.ADDITION));
            builder.put(Attributes.ATTACK_SPEED, new AttributeModifier(BASE_ATTACK_SPEED_UUID, "Item modifier", -2.4, AttributeModifier.Operation.ADDITION));
            return builder.build();
        }
        return super.getDefaultAttributeModifiers(equipmentSlot);
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public boolean isFoil(ItemStack itemstack) {
        return true;
    }

    @Override
    public void appendHoverText(ItemStack pStack, Level plevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("waitwhat.dpsvarmod.dps_tab_item").withStyle(ChatFormatting.GREEN));
        super.appendHoverText(pStack, plevel, pTooltipComponents, pIsAdvanced);
    }
    @Override
    public boolean isCorrectToolForDrops(BlockState state) {
        return true;
    }
}