package task2;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Hull {

    public Nails nails;
    public Material material;

    public Hull clone() {
        return new Hull(this.nails, this.material);
    }
}
