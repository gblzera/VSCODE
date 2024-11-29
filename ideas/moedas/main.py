import pygame
import requests

# Configurações da tela
WIDTH, HEIGHT = 400, 300
FPS = 30

# Inicializa Pygame
pygame.init()
screen = pygame.display.set_mode((WIDTH, HEIGHT))
pygame.display.set_caption("Conversor de Moedas")
clock = pygame.time.Clock()

# Função para obter as taxas de câmbio
def get_exchange_rates():
    url = "https://api.exchangerate-api.com/v4/latest/BRL"  # Usando BRL como moeda base
    response = requests.get(url)
    data = response.json()
    return data['rates']

# Função principal do aplicativo
def main():
    running = True
    rates = get_exchange_rates()
    input_amount = ""
    from_currency = "USD"  # Moeda de origem
    to_currency = "EUR"     # Moeda de destino (pode ser ajustada)
    converted_amount = 0.0

    while running:
        screen.fill((255, 255, 255))  # Cor de fundo
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                running = False
            if event.type == pygame.KEYDOWN:
                if event.key == pygame.K_RETURN:
                    # Converte a moeda
                    amount = float(input_amount) if input_amount else 0.0
                    converted_amount = amount * (rates[to_currency] / rates[from_currency])
                elif event.key == pygame.K_BACKSPACE:
                    input_amount = input_amount[:-1]
                else:
                    input_amount += event.unicode

        # Renderiza texto
        font = pygame.font.Font(None, 36)
        input_surface = font.render(f"Valor (BRL): {input_amount}", True, (0, 0, 0))
        converted_surface = font.render(f"Convertido: {converted_amount:.2f} {to_currency}", True, (0, 0, 0))
        
        screen.blit(input_surface, (20, 50))
        screen.blit(converted_surface, (20, 100))
        
        pygame.display.flip()
        clock.tick(FPS)

    pygame.quit()

if __name__ == "__main__":
    main()
