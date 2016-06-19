package matriz;

/**
 *
 * @author Felipe Rodrigues Gil - 248543
 * @version 2.0 28.08.15
 * Esta classe é a responsável por verificar quantos movimentos a dama realizou
 * a lógica partiu do ponto onde a dama apenas necessita de 2 movimentos para 
 * chegar em qualquer ponto do tabuleiro, logo a solução foi inserir verificações
 * onde se esgotaram as possibilidades de a dama realizar 0 e 1 movimento restando
 * apenas a opção de ela ter realizado 2 movimentos, abaixo os metodos estão 
 * explicados para faciliar o entendimento da lógica utilizada, o Jframe criado 
 * descartou a necessidade de colocar verificações de valores incorretos utilizados
 * pelo usuário final.
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
        int retorno;
        //se todas as coordenadas forem iguais a dama não realiza movimento
        if (a.getX() == b.getX() && a.getY() == b.getY()) {
            retorno = 0;
            /*se  as coordenadas X forem diferentes, e as coordenadas Y forem iguais
             ou as coordenadas X forem iguais e as coordenadas Y forem diferentes ou
             a subtração das coordenadas tiverem o mesmo resultado ignorando o sinal
             a dama realizou apenas 1 movimento.*/
        } else if (a.getX() != b.getX() && a.getY() == b.getY()
                || (a.getX() == b.getX() && a.getY() != b.getY()
                || (Math.abs(a.getX() - b.getX()) == Math.abs(a.getY() - b.getY())))) {
            retorno = 1;
            /*como todas as verificações de 0 ou 1 movimento foram realizadas logo apenas
             resta a possibilidade da dama realizar 2 movimentos*/
        } else {
            retorno = 2;
        }
        return retorno;
    }
}
