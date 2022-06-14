Vue.use(Autocomplete);
let search = new Vue({
    el: "#search-form",
    data: () => {
        return {
            verbSelect: false, // идикатор, выбран ли глагол
            verb: '', // текст в строке поиска
            verbControlData: [], // данные управления выбранного глагола
        }
    },
    computed: {
        // доступна ли кнопка отправки формы
        submitEnable() {
           return true;
        },
        // текущий id глагола
        verbId() {
          if (this.verbSelect) {
             return  this.verbControlData[0].verbId;
          }  else
              return 0;
        },
    },
    methods: {
        // метод вызывается всякий раз при изменении строки поиска
        search(input) {
            // если строка поиска изменилась, и до этого был выбран какой-то глагол, то нужно сбросить некоторые переменные
            if (this.verb.length > 0 && this.verb != input) {
               this.verb = '';
               this.verbSelect = false;
            }
            // формирование url запроса
            let url = "/search/" + input;

            return new Promise(resolve => {
                if (input.length < 3) { // минимальная длина запроса - 3 символа
                    return resolve([])
                }

                fetch(url)
                    .then(response =>
                        response.json())
                    .then(data => {
                        resolve(data);
                    })
            })

        },

        // функция, позволяющая задать нужное отображение для элемента
        getResultValue(result) {
            return result.value;
        },

        // callback для обработки выбора глагола
        handleSubmit(result) {
            // запрос для предлога
            let url = "/word/" + result.value;
            window.location.href = url;
        },

        handleFetchedData (data) {
            this.verbControlData = data;
            this.verbSelect = true;
        }
    },
})