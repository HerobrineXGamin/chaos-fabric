package herobrine.chaos.mixin;

import herobrine.chaos.Chaos;
import herobrine.chaos.item.ModItems;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.item.ItemModels;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.render.model.json.ModelTransformation;
import net.minecraft.client.util.ModelIdentifier;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(ItemRenderer.class)
public abstract class ItemRendererMixin {
    @Shadow
    @Final
    private ItemModels models;

    @ModifyVariable(method = "renderItem", at = @At(value = "HEAD"), argsOnly = true)
    public BakedModel useFatesInfluenceModel(BakedModel value, ItemStack stack, ModelTransformation.Mode renderMode, boolean leftHanded, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        if (stack.isOf(ModItems.FATES_INFLUENCE) && renderMode == ModelTransformation.Mode.FIXED) {
            return ((ItemRendererAccessor) this).chaos$getModels().getModelManager().getModel(new ModelIdentifier(Chaos.MOD_ID, "fates_influence_gui", "inventory"));
        }
        if (stack.isOf(ModItems.FATES_INFLUENCE) && renderMode == ModelTransformation.Mode.GUI) {
            return ((ItemRendererAccessor) this).chaos$getModels().getModelManager().getModel(new ModelIdentifier(Chaos.MOD_ID, "fates_influence_gui", "inventory"));
        }
        if (stack.isOf(ModItems.FATES_INFLUENCE) && renderMode == ModelTransformation.Mode.GROUND) {
            return ((ItemRendererAccessor) this).chaos$getModels().getModelManager().getModel(new ModelIdentifier(Chaos.MOD_ID, "fates_influence_gui", "inventory"));
        }
        if (stack.isOf(ModItems.FATES_INFLUENCE) && renderMode == ModelTransformation.Mode.NONE) {
            return ((ItemRendererAccessor) this).chaos$getModels().getModelManager().getModel(new ModelIdentifier(Chaos.MOD_ID, "fates_influence_gui", "inventory"));
        }
        if (stack.isOf(ModItems.FATES_INFLUENCE) && renderMode == ModelTransformation.Mode.FIRST_PERSON_LEFT_HAND) {
            return ((ItemRendererAccessor) this).chaos$getModels().getModelManager().getModel(new ModelIdentifier(Chaos.MOD_ID, "fates_influence_handheld", "inventory"));
        }
        if (stack.isOf(ModItems.FATES_INFLUENCE) && renderMode == ModelTransformation.Mode.FIRST_PERSON_RIGHT_HAND) {
            return ((ItemRendererAccessor) this).chaos$getModels().getModelManager().getModel(new ModelIdentifier(Chaos.MOD_ID, "fates_influence_handheld", "inventory"));
        }
        if (stack.isOf(ModItems.FATES_INFLUENCE) && renderMode == ModelTransformation.Mode.THIRD_PERSON_LEFT_HAND) {
            return ((ItemRendererAccessor) this).chaos$getModels().getModelManager().getModel(new ModelIdentifier(Chaos.MOD_ID, "fates_influence_handheld", "inventory"));
        }
        if (stack.isOf(ModItems.FATES_INFLUENCE) && renderMode == ModelTransformation.Mode.THIRD_PERSON_RIGHT_HAND) {
            return ((ItemRendererAccessor) this).chaos$getModels().getModelManager().getModel(new ModelIdentifier(Chaos.MOD_ID, "fates_influence_handheld", "inventory"));
        }
        if (stack.isOf(ModItems.FATES_INFLUENCE) && renderMode == ModelTransformation.Mode.HEAD) {
            return ((ItemRendererAccessor) this).chaos$getModels().getModelManager().getModel(new ModelIdentifier(Chaos.MOD_ID, "fates_influence_handheld", "inventory"));
        }
        if (stack.isOf(ModItems.EMPTY_FATES_INFLUENCE) && renderMode == ModelTransformation.Mode.FIXED) {
            return ((ItemRendererAccessor) this).chaos$getModels().getModelManager().getModel(new ModelIdentifier(Chaos.MOD_ID, "empty_fates_influence_gui", "inventory"));
        }
        if (stack.isOf(ModItems.EMPTY_FATES_INFLUENCE) && renderMode == ModelTransformation.Mode.GUI) {
            return ((ItemRendererAccessor) this).chaos$getModels().getModelManager().getModel(new ModelIdentifier(Chaos.MOD_ID, "empty_fates_influence_gui", "inventory"));
        }
        if (stack.isOf(ModItems.EMPTY_FATES_INFLUENCE) && renderMode == ModelTransformation.Mode.GROUND) {
            return ((ItemRendererAccessor) this).chaos$getModels().getModelManager().getModel(new ModelIdentifier(Chaos.MOD_ID, "empty_fates_influence_gui", "inventory"));
        }
        if (stack.isOf(ModItems.EMPTY_FATES_INFLUENCE) && renderMode == ModelTransformation.Mode.NONE) {
            return ((ItemRendererAccessor) this).chaos$getModels().getModelManager().getModel(new ModelIdentifier(Chaos.MOD_ID, "empty_fates_influence_gui", "inventory"));
        }
        if (stack.isOf(ModItems.EMPTY_FATES_INFLUENCE) && renderMode == ModelTransformation.Mode.FIRST_PERSON_LEFT_HAND) {
            return ((ItemRendererAccessor) this).chaos$getModels().getModelManager().getModel(new ModelIdentifier(Chaos.MOD_ID, "empty_fates_influence_handheld", "inventory"));
        }
        if (stack.isOf(ModItems.EMPTY_FATES_INFLUENCE) && renderMode == ModelTransformation.Mode.FIRST_PERSON_RIGHT_HAND) {
            return ((ItemRendererAccessor) this).chaos$getModels().getModelManager().getModel(new ModelIdentifier(Chaos.MOD_ID, "empty_fates_influence_handheld", "inventory"));
        }
        if (stack.isOf(ModItems.EMPTY_FATES_INFLUENCE) && renderMode == ModelTransformation.Mode.THIRD_PERSON_LEFT_HAND) {
            return ((ItemRendererAccessor) this).chaos$getModels().getModelManager().getModel(new ModelIdentifier(Chaos.MOD_ID, "empty_fates_influence_handheld", "inventory"));
        }
        if (stack.isOf(ModItems.EMPTY_FATES_INFLUENCE) && renderMode == ModelTransformation.Mode.THIRD_PERSON_RIGHT_HAND) {
            return ((ItemRendererAccessor) this).chaos$getModels().getModelManager().getModel(new ModelIdentifier(Chaos.MOD_ID, "empty_fates_influence_handheld", "inventory"));
        }
        if (stack.isOf(ModItems.EMPTY_FATES_INFLUENCE) && renderMode == ModelTransformation.Mode.HEAD) {
            return ((ItemRendererAccessor) this).chaos$getModels().getModelManager().getModel(new ModelIdentifier(Chaos.MOD_ID, "empty_fates_influence_handheld", "inventory"));
        }
        return value;
    }
}
