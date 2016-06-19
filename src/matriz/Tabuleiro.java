package matriz;

/**
 *
 * @author Felipe Rodrigues Gil - 248543
 */
public class Tabuleiro {

    private Ponto a;
    private Ponto b;

    public Tabuleiro(int x1, int y1, int x2, int y2) {
        a = new Ponto();
        b = new Ponto();
        a.setX(x1);
        a.setY(y1);
        b.setX(x2);
        b.setY(y2);
    }

    public int verificacao() {
        int retorno = -1;
        if (a.getX() > -1 && a.getY() > -1
                && a.getX() < 9 && a.getY() < 9
                && b.getX() > -1 && b.getY() > -1
                && b.getX() < 9 && b.getY() < 9) {         
                //finaliza a aplicação pois não foi inserido um número de 1 a 8
            if ((a.getX() + a.getY() + b.getX() + b.getY()) == 0) {
                retorno = -2;

                //retorna 0, significa que a dama está posicionada no mesmo lugar.
            } else if (a.getX() == b.getX() && a.getY() == b.getY()) {
                retorno = 0;
                //retorna 1, pois foi necessário apenas 1 movimento para chegar ao destino.
            } else if (a.getX() == b.getX() && a.getY() != b.getY()
                    && a.getX() != b.getX() && a.getY() == b.getY()) {
                retorno = 1;
                //calculo responsável para verificar movimento vertical.
            } else if(Math.abs(a.getX() - b.getX()) == Math.abs(a.getY() - b.getY())) {
                retorno = 1;
                //restou apenas retornar 2, ou seja, foi necessário 2 movimentos.
            } else {
                retorno = 2;
            }

        }
        return retorno;
    }

    public static void main(String[] args) {

        Tabuleiro t = new Tabuleiro(3, 5, 3, 5);
            //switch case para deixar o código mais apresentavel.
        switch (t.verificacao()) {
            case -2:
                System.out.println("[ERRO] Insira algum valor");
                break;
            case -1:
                System.out.println("[ERRO] Insira quatro valor entre 1 a 8");
                break;
            case 0:
                System.out.println("Movimentos: 0");
                break;
            case 1:
                System.out.println("Movimentos: 1");
                break;
            default:
                System.out.println("Movimentos: 2");

        }

    }

}
