package top.cuteworkd.nn;

/**
 * 激活函数
 */
public interface IActivationFunction {
    double calc(double x);
    public enum ActivationFunctionENUM {
        STEP, LINEAR, SIGMOID, HYPERTAN
    }
}
