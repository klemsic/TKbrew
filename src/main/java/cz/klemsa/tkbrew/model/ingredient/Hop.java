package cz.klemsa.tkbrew.model.ingredient;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Class that's represents hop.
 * @author tomasklemsa
 */
@Document(collection = "ingredient")
public final class Hop extends Ingredient {
    private static final double DEFAULT_ALPHA = 0.0;
    private static final double DEFAULT_BETA = 0.0;

    private final double alpha;
    private final double beta;

    /**
     * No-arg constructor that's create hop with default fields.
     */
    public Hop() {
        this(null, null, DEFAULT_ALPHA, DEFAULT_BETA);
    }

    /**
     *
     * @param name of ingredient
     * @param description of ingredient
     * @param alpha acids, 10% of alpha acids = 0.1
     * @param beta acids, 10% of beta acids = 0.1
     */
    public Hop(String name, String description, Double alpha, Double beta) {
        this(new ObjectId(), name, description, alpha, beta);
    }

    /**
     *
     * @param objectId used to persist
     * @param name of ingredient
     * @param description of ingredient
     * @param alpha acids, 10% of alpha acids = 0.1
     * @param beta acids, 10% of beta acids = 0.1
     */
    @PersistenceConstructor
    public Hop(ObjectId objectId, String name, String description, Double alpha, Double beta) {
        super(objectId, name, description);
        this.alpha = alpha == null ? DEFAULT_ALPHA : alpha;
        this.beta = beta == null ? DEFAULT_BETA : beta;
    }

    public double getAlpha() {
        return alpha;
    }

    public double getBeta() {
        return beta;
    }
}
