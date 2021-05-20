const subscriptionEnd = document.getElementById("profile-subscription-end")
const subscriptionDays = document.getElementById("profile-subscription-days")

const getSubscriptionDays = () => {
    const startDate = new Date()

    const end = subscriptionEnd.innerHTML.split(".")
    const endDate = new Date(+end[2], end[1] - 1, +end[0])

    const days = Math.ceil(
        (endDate.getTime() - startDate.getTime()) / (1000 * 3600 * 24)
    )
    subscriptionDays.innerHTML = days < 0 ? `0 дней` : `${days} дней`
}
getSubscriptionDays()