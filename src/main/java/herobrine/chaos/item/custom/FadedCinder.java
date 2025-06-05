package herobrine.chaos.item.custom;

import herobrine.chaos.block.ModBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import xyz.amymialee.mialeemisc.util.MialeeText;

import java.util.List;

public class FadedCinder extends Item {
    public FadedCinder(Settings settings) {
        super(settings);
    }
    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if(Screen.hasShiftDown()) {
            tooltip.add(Text.literal("A cinder long since shorn of kindling, yet still it whispereth of unquenched flame.").formatted(Formatting.GRAY).formatted(Formatting.ITALIC));
            tooltip.add(Text.literal("Touch it to ancient stone, and wake the dark that slumbereth underneath the ash.").formatted(Formatting.GRAY).formatted(Formatting.ITALIC));
        } else {
            tooltip.add(Text.literal("Press [Sneak] to show Story.").formatted(Formatting.DARK_GRAY));
        }

        super.appendTooltip(stack, world, tooltip, context);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        BlockPos pos = context.getBlockPos();
        PlayerEntity player = context.getPlayer();
        ItemStack stack = context.getStack();
        BlockState clickedBlock = world.getBlockState(pos);

        if (clickedBlock.getBlock() == Blocks.ANCIENT_DEBRIS) {
            if (!world.isClient) {
                // Replace with your custom block
                world.setBlockState(pos, ModBlocks.UMBRALIUM_DEBRIS.getDefaultState());

                // Decrease the item (optional)
                stack.decrement(1);

                // Sound (optional)
                world.playSound(null, pos, SoundEvents.BLOCK_FIRE_EXTINGUISH, SoundCategory.BLOCKS, 1.0f, 1.0f);

                // Spawn large smoke particles (centered on block)
                for (int i = 0; i < 10; i++) {
                    double x = pos.getX() + 0.5 + (world.random.nextDouble() - 0.5);
                    double y = pos.getY() + 0.5 + (world.random.nextDouble() - 0.5);
                    double z = pos.getZ() + 0.5 + (world.random.nextDouble() - 0.5);
                    world.addParticle(ParticleTypes.LARGE_SMOKE, x, y, z, 0.0, 0.1, 0.0);
                }
            }
            return ActionResult.SUCCESS;
        }

        return ActionResult.PASS;
    }

    @Override
    public Text getName(ItemStack stack) {
        return MialeeText.withColor(super.getName(stack), 0x342B2B);
    }
}
