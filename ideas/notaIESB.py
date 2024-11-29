import pygame
import sys

# Inicialização do Pygame
pygame.init()

# Configurações da tela
screen_width, screen_height = 800, 600
screen = pygame.display.set_mode((screen_width, screen_height))
pygame.display.set_caption("Calculadora de Médias")

# Cores
DARK_GRAY = (30, 30, 30)  # Fundo escuro
WHITE = (255, 255, 255)
GREEN = (0, 255, 0)
RED = (255, 0, 0)
LIGHT_GRAY = (200, 200, 200)

# Fonte
font = pygame.font.Font(None, 48)
input_font = pygame.font.Font(None, 36)

# Função para calcular a média
def calcular_media(nota1, nota2):
    peso1 = 0.4
    peso2 = 0.6
    return (nota1 * peso1 + nota2 * peso2)

# Função para calcular a nota necessária na segunda prova
def calcular_nota_prova(nota_menor, peso_menor):
    media_desejada = 5
    return (media_desejada - (nota_menor * peso_menor)) / (1 - peso_menor)

# Loop principal
def main():
    input_nota1 = ""
    input_nota2 = ""
    nota1 = None
    nota2 = None
    media = None
    nota_menor = None
    peso_menor = None
    nota_prova = None

    cursor_visible = True
    cursor_timer = pygame.time.get_ticks()

    while True:
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                pygame.quit()
                sys.exit()

            if event.type == pygame.KEYDOWN:
                if event.key == pygame.K_RETURN:
                    if nota1 is None:  # Primeiro cálculo (1ª Nota)
                        try:
                            nota1 = float(input_nota1)
                            if 0 <= nota1 <= 10:
                                input_nota1 = ""  # Limpa a entrada após calcular
                            else:
                                nota1 = None
                        except ValueError:
                            nota1 = None
                            input_nota1 = ""
                    elif nota2 is None:  # Segundo cálculo (2ª Nota)
                        try:
                            nota2 = float(input_nota2)
                            if 0 <= nota2 <= 10:
                                media = calcular_media(nota1, nota2)
                                # Verifica se a nota2 é menor que a média necessária
                                if nota2 < (5 - (nota1 * 0.4)):
                                    nota_menor = nota1 if nota1 < nota2 else nota2
                                    peso_menor = 0.4 if nota_menor == nota1 else 0.6
                                    nota_prova = calcular_nota_prova(nota_menor, peso_menor)
                                input_nota2 = ""  # Limpa a entrada após calcular
                            else:
                                nota2 = None
                        except ValueError:
                            nota2 = None
                            input_nota2 = ""
                elif event.key == pygame.K_BACKSPACE:
                    if nota1 is None:
                        input_nota1 = input_nota1[:-1]  # Remove o último caractere
                    else:
                        input_nota2 = input_nota2[:-1]  # Remove o último caractere
                else:
                    if nota1 is None:
                        input_nota1 += event.unicode  # Adiciona o caractere digitado
                    else:
                        input_nota2 += event.unicode  # Adiciona o caractere digitado

        # Atualização da tela
        screen.fill(DARK_GRAY)

        # Renderiza a entrada e o resultado
        input_text1 = input_font.render(f"1ª Nota: {input_nota1}", True, LIGHT_GRAY)
        screen.blit(input_text1, (50, 100))

        if nota1 is not None:
            input_text2 = input_font.render(f"2ª Nota: {input_nota2}", True, LIGHT_GRAY)
            screen.blit(input_text2, (50, 150))

        if media is not None:
            resultado_text = f"Média: {media:.2f}"
            color = GREEN if media >= 5 else RED
            result_surface = font.render(resultado_text, True, color)
            screen.blit(result_surface, (50, 250))

            if nota_prova is not None:
                resultado_prova_text = f"Nota necessária na prova: {nota_prova:.2f} para substituir {nota_menor:.2f}"
                result_surface_prova = font.render(resultado_prova_text, True, RED)
                screen.blit(result_surface_prova, (50, 300))

        instructions = font.render("Pressione ENTER para calcular", True, LIGHT_GRAY)
        screen.blit(instructions, (50, 50))

        # Desenho do cursor
        if cursor_visible:
            cursor_surface = font.render("|", True, LIGHT_GRAY)
            if nota1 is None:
                screen.blit(cursor_surface, (50 + input_font.size(input_nota1)[0], 100))
            else:
                screen.blit(cursor_surface, (50 + input_font.size(input_nota2)[0], 150))

        # Alterna a visibilidade do cursor
        if pygame.time.get_ticks() - cursor_timer > 500:  # Cursor pisca a cada 500ms
            cursor_visible = not cursor_visible
            cursor_timer = pygame.time.get_ticks()

        pygame.display.flip()

# Executa a função principal
if __name__ == "__main__":
    main()
