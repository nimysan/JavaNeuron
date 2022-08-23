package top.cuteworld.nn;

//public class NeuralNet  {
//
//    private InputLayer inputLayer;
//    private ArrayList<HiddenLayer> hiddenLayer;
//    private OutputLayer outputLayer;
//    private int numberOfHiddenLayers;
//    private int numberOfInputs;
//    private int numberOfOutputs;
//    private ArrayList<Double> input;
//    private ArrayList<Double> output;
//
//    public NeuralNet(int numberofinputs, int numberofoutputs,
//                     int[] numberofhiddenneurons, IActivationFunction[] hiddenAcFnc,
//                     IActivationFunction outputAcFnc) {
//        numberOfHiddenLayers = numberofhiddenneurons.length;
//        numberOfInputs = numberofinputs;
//        numberOfOutputs = numberofoutputs;
//        if (numberOfHiddenLayers == hiddenAcFnc.length) {
//            input = new ArrayList<>(numberofinputs);
//            inputLayer = new InputLayer(numberofinputs);
//            if (numberOfHiddenLayers > 0) {
//                hiddenLayer = new ArrayList<>(numberOfHiddenLayers);
//            }
//            for (int i = 0; i < numberOfHiddenLayers; i++) {
//                if (i == 0) {
//                    try {
//                        hiddenLayer.set(i, new HiddenLayer(numberofhiddenneurons[i],
//                                hiddenAcFnc[i],
//                                inputLayer.getNumberOfNeuronsInLayer()));
//                    } catch (IndexOutOfBoundsException iobe) {
//                        hiddenLayer.add(new HiddenLayer(numberofhiddenneurons[i],
//                                hiddenAcFnc[i],
//                                inputLayer.getNumberOfNeuronsInLayer()));
//                    }
//                    inputLayer.setNextLayer(hiddenLayer.get(i));
//                } else {
//                    try {
//                        hiddenLayer.set(i, new HiddenLayer(numberofhiddenneurons[i],
//                                hiddenAcFnc[i], hiddenLayer.get(i - 1)
//                                .getNumberOfNeuronsInLayer()
//                        ));
//                    } catch (IndexOutOfBoundsException iobe) {
//                        hiddenLayer.add(new HiddenLayer(numberofhiddenneurons[i],
//                                hiddenAcFnc[i], hiddenLayer.get(i - 1)
//                                .getNumberOfNeuronsInLayer()
//                        ));
//                    }
//                    hiddenLayer.get(i - 1).setNextLayer(hiddenLayer.get(i));
//                }
//            }
//            if (numberOfHiddenLayers > 0) {
//                outputLayer = new OutputLayer(numberofoutputs, outputAcFnc,
//                        hiddenLayer.get(numberOfHiddenLayers - 1)
//                                .getNumberOfNeuronsInLayer()
//                );
//                hiddenLayer.get(numberOfHiddenLayers - 1).setNextLayer(outputLayer);
//            } else {
//                outputLayer = new OutputLayer(numberofinputs, outputAcFnc,
//                        numberofoutputs);
//                inputLayer.setNextLayer(outputLayer);
//            }
//        }
//    }
//}outputLayer
