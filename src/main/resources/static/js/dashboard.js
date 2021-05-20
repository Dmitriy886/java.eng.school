const setUserInputs = (event) => {
    const target =
        event.target.className === "ri-pencil-fill"
            ? event.target.parentElement
            : event.target

    const { attributes } = target

    Array.from(attributes).forEach((el) => {
        const inputId = `${el.name}_input`

        if (inputId !== "class_input" && inputId !== "onclick_input") {
            const inputNode = document.getElementById(inputId)
            if (inputNode !== null)
                inputNode.value = el.value
        }
    })
}

const initUserInput = () => {
    const elements = document.getElementsByClassName("admin-profile_user-edit")

    if (elements.length > 0) elements[0].click()
}
initUserInput()