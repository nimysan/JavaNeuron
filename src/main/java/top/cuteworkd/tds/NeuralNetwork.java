package top.cuteworkd.tds;

import java.util.List;

/**
 * 三层
 * 1 输入
 * 2 一层Hidden layere
 * 3 输出
 */
public class NeuralNetwork {

    Matrix weights_ih, weights_ho, bias_h, bias_o;
    double l_rate = 0.01;

    public NeuralNetwork(int i, int h, int o) {
        weights_ih = new Matrix(h, i);
        weights_ho = new Matrix(o, h);

        bias_h = new Matrix(h, 1);
        bias_o = new Matrix(o, 1);

    }

    /**
     * <img src="forward_pass.png"> 推理使用 </img>
     *
     * @param X
     * @return
     */
    public List<Double> predict(double[] X) {
        Matrix input = Matrix.fromArray(X);
        Matrix hidden = Matrix.multiply(weights_ih, input); // 初始的时候 weights_ih 是随机的权重, 跟输入做乘法
        hidden.add(bias_h); //加 偏置
        hidden.sigmoid(); // 走一遍激活函数

        Matrix output = Matrix.multiply(weights_ho, hidden);
        output.add(bias_o);
        output.sigmoid();

        return output.toArray();
    }


    public void fit(double[][] X, double[][] Y, int epochs) {
        for (int i = 0; i < epochs; i++) {
            int sampleN = (int) (Math.random() * X.length);
            this.train(X[sampleN], Y[sampleN]);
        }
    }

    /**
     * 一个最简单的三层神经网路（input-hidden(1)-output)
     *
     * @param X
     * @param Y
     */
    public void train(double[] X, double[] Y) {


        Matrix input = Matrix.fromArray(X);

        // input - hidden
        Matrix hidden = Matrix.multiply(weights_ih, input); // 初始的时候 weights_ih 是随机的权重, 跟输入做乘法
        hidden.add(bias_h); // 增加bias
        hidden.sigmoid(); // 走一遍sigmoid 激活函数

        // hidden - output
        Matrix output = Matrix.multiply(weights_ho, hidden);// 将上一层作为输入，weights_ho做乘法
        output.add(bias_o); // 增加 bias
        output.sigmoid(); // 继续走一遍sigmoid 激活函数

        /**
         * 以上, 其实每一层都是做这个三个操作
         */


        /**
         *  以下， 是根据输入的数据做监督和结果确认 （backpropagation - 反向传播)
         */

        /**
         * Backpropagation is just the reverse of the forward pass in which we take the transpose
         * of the weight matrices and then multiply them with the gradient calculated from the errors,
         * which in turn return the deltas that are used to adjust the weights in the current layer.
         * The bias are updated using the gradients.
         */
        Matrix target = Matrix.fromArray(Y);

        //hidden layer 反向
        Matrix error = Matrix.subtract(target, output); // 根据输出和给定的结果， 结算错误率
        Matrix gradient = output.dsigmoid();
        gradient.multiply(error); // 错误率被用来计算梯度 -  This error is used to calculate gradients for the backpropagation.
        gradient.multiply(l_rate);


        Matrix hidden_T = Matrix.transpose(hidden);
        Matrix who_delta = Matrix.multiply(gradient, hidden_T);

        weights_ho.add(who_delta);
        bias_o.add(gradient);


        //input layer 反向
        Matrix who_T = Matrix.transpose(weights_ho);
        Matrix hidden_errors = Matrix.multiply(who_T, error);

        Matrix h_gradient = hidden.dsigmoid();
        h_gradient.multiply(hidden_errors);
        h_gradient.multiply(l_rate);

        Matrix i_T = Matrix.transpose(input);
        Matrix wih_delta = Matrix.multiply(h_gradient, i_T);

        weights_ih.add(wih_delta);
        bias_h.add(h_gradient);

    }


}