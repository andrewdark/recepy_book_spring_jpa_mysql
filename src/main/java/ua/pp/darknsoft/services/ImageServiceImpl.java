package ua.pp.darknsoft.services;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ua.pp.darknsoft.models.Recipe;
import ua.pp.darknsoft.repositories.RecipeRepository;

@Service
public class ImageServiceImpl implements ImageService {
    private final RecipeRepository recipeRepository;

    public ImageServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public void saveImageFile(Long recipeId, MultipartFile file) {
        try {
            Recipe recipe = recipeRepository.findById(recipeId).get();

            Byte[] byteObjects = new Byte[file.getBytes().length];

            int i = 0;

            for (byte b : file.getBytes()) {
                byteObjects[i++] = b;
            }

            recipe.setImage(byteObjects);

            recipeRepository.save(recipe);
        } catch (Exception ex) {
            System.out.println("Save image error: " + ex);
        }
    }
}
