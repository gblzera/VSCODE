from selenium import webdriver
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.common.by import By
import time

linkedin_email = 'gabriel.kpaz@gmail.com'
linkedin_password = 'Ser41173525'
search_query = 'programador'  
personalized_message = 'Olá {name}, sou estudante de Engenharia da Computação, atualmente no sexto semestre da faculdade. Tenho um grande interesse em programação e estou sempre em busca de novas oportunidades para aplicar e expandir meus conhecimentos na área. Estou entusiasmado para explorar e contribuir para projetos desafiadores e inovadores. Agradeço a oportunidade de me apresentar e estou à disposição para conversar mais sobre possíveis colaborações ou oportunidades.'

driver = webdriver.Chrome()
driver.get('https://www.linkedin.com/login/pt?fromSignIn=true&trk=guest_homepage-basic_nav-header-signin')

email_input = driver.find_element(By.ID, 'username')
password_input = driver.find_element(By.ID, 'password')
email_input.send_keys(linkedin_email)
password_input.send_keys(linkedin_password)
password_input.send_keys(Keys.RETURN)

time.sleep(5)  

search_input = driver.find_element(By.XPATH, '//input[@placeholder="Pesquisar"]')
search_input.send_keys(search_query)
search_input.send_keys(Keys.RETURN)

time.sleep(5)

driver.find_element(By.LINK_TEXT, 'Pessoas').click()

time.sleep(5)  

profiles = driver.find_elements(By.CSS_SELECTOR, '.reusable-search__result-container')
for profile in profiles:
    try:
        name_element = profile.find_element(By.CSS_SELECTOR, '.entity-result__title-text')
        name = name_element.text.split('\n')[0]

        connect_button = profile.find_element(By.CSS_SELECTOR, '.artdeco-button--secondary')
        connect_button.click()

        time.sleep(2) 

        add_note_button = driver.find_element(By.XPATH, '//button[contains(text(), "Adicionar uma nota")]')
        add_note_button.click()

        time.sleep(2)  

        note_input = driver.find_element(By.XPATH, '//textarea[@name="message"]')
        note_input.send_keys(personalized_message.format(name=name))

        send_button = driver.find_element(By.XPATH, '//button[contains(text(), "Enviar")]')
        send_button.click()

        time.sleep(2)  

    except Exception as e:
        print(f'Erro ao processar perfil: {e}')

driver.quit()