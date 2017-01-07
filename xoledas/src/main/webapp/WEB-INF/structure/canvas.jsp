<c:out value="${name}" />

<canvas id="myChart" height="300" width="1000px"></canvas>

<script>
	var ctx = document.getElementById('myChart');
			
	var options = {
		responsive: false,
		maintainAspectRatio: false
	};
			
	var myChart = new Chart(ctx, {
		type: 'line',
		data: {
			labels: ['M', 'T', 'W', 'T', 'F', 'S', 'S', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A'],
			datasets: [{
				label: 'apples',
				data: [12, 19, 3, 17, 6, 3, 7],
				backgroundColor: "rgba(153,255,51,0.4)"
				}, {
				label: 'oranges',
				data: [2, 29, 5, 5, 2, 3, 10],
				backgroundColor: "rgba(255,153,0,0.4)"
				}]
		},
		options: options
	});
	
</script>