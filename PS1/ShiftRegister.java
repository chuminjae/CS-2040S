///////////////////////////////////
// This is the main shift register class.
// Notice that it implements the ILFShiftRegister interface.
// You will need to fill in the functionality.
///////////////////////////////////

/**
 * class ShiftRegister
 * @author
 * Description: implements the ILFShiftRegister interface.
 */
public class ShiftRegister implements ILFShiftRegister {
    ///////////////////////////////////
    // Create your class variables here
    ///////////////////////////////////
    // TODO:
    public int seed[];
    public int tap = -1;
    public int size = -1;
    

    ///////////////////////////////////
    // Create your constructor here:
    ///////////////////////////////////
    ShiftRegister(int size, int tap) {
        // TODO:
        this.size = size;
        this.tap = tap;
    }

    ///////////////////////////////////
    // Create your class methods here:
    ///////////////////////////////////
    /**
     * setSeed
     * @param seed
     * Description:
     */
    @Override
    public void setSeed(int[] seed) {
        // TODO:
        this.seed = seed;
        this.size = seed.length;
    }

    /**
     * shift
     * @return
     * Description:
     */
    @Override
    public int shift() {
        // TODO:
        int new_bit = seed[size - 1] ^ seed[tap];
        int [] tmp = new int[size];
        tmp[0] = new_bit;
        for(int i = 1; i < size; i = i + 1){
            tmp[i] = seed[i - 1];
        }
        seed = tmp;
        return new_bit;
    }

    /**
     * generate
     * @param k
     * @return
     * Description:
     */
    @Override
    public int generate(int k) {
        // TODO:
        int result = 0;
        for(int i = k; i > 0; i --){
            result += shift() * (int)Math.pow(2, i - 1);
        }
        return result;
    }

    /**
     * Returns the integer representation for a binary int array.
     * @param array
     * @return
     */
    private int toDecimal(int[] array) {
        // TODO:
        return 0;
    }
    public static void main(String[] args) {
        ILFShiftRegister r = new ShiftRegister(5,3);
        int[] seed = {1,0,0,1,1};
        int [] tmp = new int [5];
        r.setSeed(seed);
        for(int i = 0; i < 5; i = i + 1){
            tmp[i] = r.generate(4);
            System.out.println(tmp[i]);
        }

    }
    }

